package Convert.domain;

public enum AvailableCurrency {
    RUB {
        public String declinationCurrency(int lastNumber) {
            if (lastNumber == 1)
                return " рубль ";
            if (lastNumber >= 2 && lastNumber <= 4)
                return " рубля ";
            if (lastNumber >= 5 && lastNumber <= 9 || lastNumber == 0)
                return " рублей ";
            return " руб. ";
        }
    },
    DOLLAR {
        public String declinationCurrency(int lastNumber) {
            if (lastNumber == 1)
                return " доллар ";
            if (lastNumber >= 2 && lastNumber <= 4)
                return " доллара ";
            if (lastNumber >= 5 && lastNumber <= 9 || lastNumber == 0)
                return " долларов ";
            return " млн. ";
        }

    };

    public abstract String declinationCurrency(int lastNumber);
}
