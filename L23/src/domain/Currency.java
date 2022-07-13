package src.domain;

enum Currency {
    RUB{
        public String declination(int lastNumber) {
            if(lastNumber == 1)
                return new String(" рубль ");
            if(lastNumber >= 2 || lastNumber <= 4)
                return new String(" рубля ");
            if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                return new String(" рублей ");
            return new String(" руб. ");
        }
    },
    DOLLAR{
        public String declination(int lastNumber) {
            if(lastNumber == 1)
                return new String(" доллар ");
            if(lastNumber >= 2 || lastNumber <= 4)
                return new String(" доллара ");
            if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                return new String(" долларов ");
            return new String(" млн. ");
        };
    };
        public abstract String declination(int lastNumber);   
    }
