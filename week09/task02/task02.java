//Einleser
class task02 { //org. Pattern

    public static void main(String args[]) {
   
		int i = 1;
		double price;
		DayTrader trader = null;
		System.out.println("┏━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━┳━━━━━━━┓");
		System.out.println("┃period ┃    price ┃     cash ┃   shares ┃    value ┃ trade ┃");
		System.out.println("┣━━━━━━━╋━━━━━━━━━━╋━━━━━━━━━━╋━━━━━━━━━━╋━━━━━━━━━━╋━━━━━━━┫");
		while (!StdIn.isEmpty()) {
			price = StdIn.readDouble();
			if (trader == null) {
				trader = new DayTrader(price);
			} else {
				trader.setPrice(price);
			}
			System.out.printf("┃%5d  ┃ %8.2f ┃ %8.2f ┃ %8.2f ┃ %8.2f ┃ %s  ┃\n", i, price, trader.invest.cash, trader.invest.shares, (trader.invest.cash + trader.invest.shares*price), trader.toString()); // Verschoben, um ersten print des Beispiels zu realisieren....
			i++;
		}
		System.out.println("┗━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━┻━━━━━━━┛\n");

		double profit = 0.0;
		try {
			profit = (trader.invest.cash + trader.invest.shares*trader.read_price())/10000.0;
		} catch (Exception e) {
		 	profit = 0.0;
		}

		System.out.println("╔═══════╦══════════╦══════════╦══════════╦══════════╦══════════╗");
		System.out.printf("║  Cash ║ %8.2f ║   shares ║ %8.2f ║   profit ║%8.2f⁒ ║\n", trader.invest.cash, trader.invest.shares, profit);
		System.out.println("╚═══════╩══════════╩══════════╩══════════╩══════════╩══════════╝");
	}
}


//Mustererkennung
class DayTrader {

	State state = null;
	Invest invest = null;

    public DayTrader(double p) {	
		//Status initialisierung
		state = new State();
		invest = new Invest(10000.00);
		
		price = p;
    }

    // setter ----------------------------------------------
    public void setPrice(double p) {
		if (p > price) {
			state.set_up();
		} else if (p < price) {
			state.set_down();
		} else {
			state.set_nothing();
		}

		current = state.get_current();
		price = p;
		
		// Cash wird falls eine Phase (BUY/SELL) kommen sollte, umgetauscht
		switch (state.status) {
			case "BUY ": invest.buy_shares(price); break;
			case "SELL": invest.sell_shares(price); break;
		}
	}
	public String toString() {
		switch (state.status) {
			case "NONE": return "    ";
			case "START": return "    ";
			default: return state.status;
		}
	}

	public double read_price() {
		return price;
	}
    // private ---------------------------------------------
    private double price;
    private double current; // WARUM???? In State gibt es schon einen CURRENT?

}

class State {
	static String status; //symbolische Konstante
	
	static private int current; //aktueller Status (up/down) -> WARUM PRIVATE, DASS IST TOTALER SCHWACHSINN????
	
	public State() {
		status = "START";
		current = 0;
	}
	
	public static int get_current() {
		return current;
	}
	
	public static void set_down() {
		if (status == "SELL") {
			current = -2;
			status = "NONE";
		} else if (status == "BUY ") {
			current = -1;
			status = "NONE";
		} else if (current > 0) {
			if (current >= 3) {
				status = "SELL";
			} else {
				current = -1;
			}
		} else {
			current -= 1;
		}
	}
	
	public static void set_up() {
		if (status == "SELL") {
			current = 1;
			status = "NONE";
		} else if (status == "BUY ") {
			current = 2;
			status = "NONE";
		} else if (current < 0) {
			if (current <= -3) {
				status = "BUY ";
			} else {
				current = 1;
			}
		} else {
			current += 1;
		}
	}
	
	public static void set_nothing() { // Wenn der Share nach einem Sell/Buy sich nicht verändert, wird diese auf eine Stelle mit gleichem Verlauf gesetzt und der Status auf NONE gesetzt
		if (status == "SELL") {
			current = -1;
			status = "NONE";
		} else if (status == "BUY ") {
			current = 1;
			status = "NONE";
		} 
	}
}

class Invest {
	protected static double cash; // Protectet = Wert kann von außen gelesen, aber nicht verändert werden
	protected static double shares;
	protected static double cash_start;
	
	public Invest(double c) {
		cash = c;
		shares = 0.0;
		cash_start = c;
	}
	
	public static void buy_shares(double price) {
		if (shares == 0) { // Wenn schon das ganze Wert in Shares liegt (laut algoritmus muss gekauft werden) -> Nach einer Buy-Phase kommt noch eine -> Kein Geld mehr in Cash vorhanden, alles in Shares
			shares = cash/price;
			cash = 0;
		}
	}
	
	public static void sell_shares(double price) {
		if (cash == 0) { // Wenn schon das ganze Wert in Geld liegt (laut algoritmus muss verkauft werden) -> Nach einer Sell-Phase kommt noch eine -> Kein Geld mehr in Shares vorhanden, alees in Cash
			cash = shares * price;
			shares = 0;
		}
	}
}
