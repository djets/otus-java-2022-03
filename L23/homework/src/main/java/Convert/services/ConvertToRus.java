package Convert.services;

import Convert.appService.ConvertService;
import Convert.domain.NumbersOfWordsRus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ConvertToRus implements ConvertService<ArrayDeque<Integer>, String> {

    protected String convertString;

    public ConvertToRus() {
        convertString = "";
    }

    @Override
    public String convert(ArrayDeque<Integer> inputStringsNumber) {

        List<String> wordsList = NumbersOfWordsRus.getWordsList();
        //передоваемый остаток  
        int transmittedRemainderInTheBlock;
        //Количество делений
        int numbersOfBlocks;
        //остаток
        int remainsOfBlocks = inputStringsNumber.size() % 3;

        if (remainsOfBlocks > 0) {
            numbersOfBlocks = inputStringsNumber.size() / 3 + 1;
            transmittedRemainderInTheBlock = remainsOfBlocks;
        } else {
            numbersOfBlocks = inputStringsNumber.size() / 3;
            transmittedRemainderInTheBlock = 3;
        }

        for (int i = 0; i < numbersOfBlocks; i++) {
            //Инициализация блока с тремя или менее числами
            List<Integer> blocks = new ArrayList<>();
            for (int p = 1; p <= transmittedRemainderInTheBlock; p++) {
                blocks.add((inputStringsNumber.pollFirst()));
            }
            //Вызов метода конвертации блока чисел
            upToAThousand(blocks, wordsList, transmittedRemainderInTheBlock);
            //Проверка на присутсвие в блоке только нулей
            if (!checkingFullZero(blocks)) {
                //проверка на окончание в блоке от 10 до 19
                if (blocks.size() > 1 && blocks.get(blocks.size() - 2) == 1) {
                    convertString += getNumeralString(numbersOfBlocks, i, 5);
                } else {
                    convertString += getNumeralString(numbersOfBlocks, i, blocks.get(blocks.size() - 1));
                }
            }
            if (i < numbersOfBlocks - 1) {
                convertString += " ";
            }
            transmittedRemainderInTheBlock = 3;
        }
        //Удаление пробелов в конце строки
        if (convertString.endsWith(" ")) {
            convertString = convertString.substring(0, convertString.length() - 1);
        }
        //Вывод строи с удалением двойных пробелов
        return convertString.replace("  ", " ");
    }

    //Преобразование трехзначных чисел
    void upToAThousand(List<Integer> blocks, List<String> wordsList, int transmittedRemainderInTheBlock) {
        if (transmittedRemainderInTheBlock == 3) {
            if (blocks.get(0) == 1) {
                convertString += wordsList.get(17) + " ";
            }
            if (blocks.get(0) == 2) {
                convertString += wordsList.get(12) + wordsList.get(19) + " ";
            }
            if (blocks.get(0) == 3 || blocks.get(0) == 4) {
                convertString += wordsList.get(blocks.get(0)) + wordsList.get(18) + " ";
            }
            if (blocks.get(0) > 4 && blocks.get(0) <= 9) {
                convertString += wordsList.get(blocks.get(0)) + wordsList.get(20) + " ";
            }

            if (!checkingZero(blocks)) {
                transmittedRemainderInTheBlock -= 1;
                upToAHundred(blocks, transmittedRemainderInTheBlock, wordsList, 1);
            } else {
                convertString = convertString.substring(0, convertString.length() - 1);
            }
        } else {
            upToAHundred(blocks, transmittedRemainderInTheBlock, wordsList, 0);
        }
    }

    //Преобразование двухзначных чисел
    void upToAHundred(List<Integer> blocks, int transmittedRemainderInTheBlock, List<String> wordsList, int i) {
        //0-9
        if (transmittedRemainderInTheBlock == 1) {
            convertString += wordsList.get(blocks.get(i));
        }

        if (transmittedRemainderInTheBlock == 2) {
            if (blocks.get(i) == 0) {
                convertString += wordsList.get(blocks.get(1 + i));
            }
            //11-19
            if (blocks.get(i) == 1) {

                if (blocks.get(1) != 3) {
                    final String numberWords = wordsList.get(blocks.get(1 + i));
                    if (blocks.get(1 + i) == 2) {
                        convertString += numberWords.substring(0, numberWords.length() - 1) + "енадцать";
                    } else {
                        //10
                        if (blocks.get(i) == 1 && blocks.get(1 + i) == 0) {
                            convertString += wordsList.get(10) + "->";
                        } else {
                            convertString += numberWords.substring(0, numberWords.length() - 1) + "надцать";
                        }
                    }
                } else {
                    convertString += wordsList.get(blocks.get(1 + i)) + "надцать";
                }
            } else {
                //20-39 
                if (blocks.get(i) == 2 || blocks.get(i) == 3) {
                    if (blocks.get(1) == 0) {
                        convertString += wordsList.get(blocks.get(i)) + "дцать";
                    } else {
                        convertString += wordsList.get(blocks.get(i)) + "дцать " + wordsList.get(blocks.get(1 + i));
                    }
                }
                //40-49
                if ((blocks.get(i) == 4)) {
                    if (blocks.get(1 + i) == 0) {
                        convertString += wordsList.get(14);
                    } else {
                        convertString += wordsList.get(14) + " " + wordsList.get(blocks.get(1 + i));
                    }
                }
                //90-99
                if ((blocks.get(i) == 9)) {
                    if (blocks.get(1 + i) == 0) {
                        convertString += wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто";
                    } else {
                        convertString += wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто " + wordsList.get(blocks.get(1 + i));
                    }
                }
                //50,60,70... 
                if (blocks.get(i) > 4 && blocks.get(i) < 9) {
                    if (blocks.get(1 + i) == 0) {
                        convertString += wordsList.get(blocks.get(i)) + "десят";
                    } else {
                        convertString += wordsList.get(blocks.get(i)) + "десят " + wordsList.get(blocks.get(1 + i));
                    }
                }
            }
        }
    }

    //Разряды чисел
    enum Numerals {
        THOUSANDS {
            public String declension(int lastNumber) {
                if (lastNumber == 1)
                    return " тысяча ";
                if (lastNumber >= 2 && lastNumber <= 4)
                    return " тысячи ";
                if (lastNumber >= 5 && lastNumber <= 9 || lastNumber == 0)
                    return " тысяч ";
                return " тыс. ";
            }
        },
        MILLIONS {
            public String declension(int lastNumber) {
                if (lastNumber == 1)
                    return " миллион ";
                if (lastNumber >= 2 && lastNumber <= 4)
                    return " миллиона ";
                if (lastNumber >= 5 && lastNumber <= 9 || lastNumber == 0)
                    return " миллионов ";
                return " млн. ";
            }
        },
        MILLIARDS {
            public String declension(int lastNumber) {
                if (lastNumber == 1)
                    return " миллиард ";
                if (lastNumber >= 2 && lastNumber <= 4)
                    return " миллиарда ";
                if (lastNumber >= 5 && lastNumber <= 9 || lastNumber == 0)
                    return " миллиардов ";
                return " мрд. ";
            }
        };

        public abstract String declension(int lastNumber);
    }

    //Запрос разряда числа
    private static String getNumeralString(int numbersOfBlocks, int iterate, int lastNum) {

        if (iterate == 0 && numbersOfBlocks == 2) {
            return Numerals.THOUSANDS.declension(lastNum);
        }

        if (iterate == 0 && numbersOfBlocks == 3) {
            return Numerals.MILLIONS.declension(lastNum);
        }
        if (iterate == 1 && numbersOfBlocks == 3) {
            return Numerals.THOUSANDS.declension(lastNum);
        }

        if (iterate == 0 && numbersOfBlocks == 4) {
            return Numerals.MILLIARDS.declension(lastNum);
        }
        if (iterate == 1 && numbersOfBlocks == 4) {
            return Numerals.MILLIONS.declension(lastNum);
        }
        if (iterate == 2 && numbersOfBlocks == 4) {
            return Numerals.THOUSANDS.declension(lastNum);
        }

        return "";
    }

    //Проверка нулей в остатке для чисел 100, 200, 1000 и т.д.
    private static boolean checkingZero(List<Integer> listOfIntegers) {
        if (listOfIntegers.size() > 1) {
            return listOfIntegers.get(1) == 0 && listOfIntegers.get(2) == 0;
        }
        return false;
    }

    //Проверка на присутсвие в блоке только нулей
    private static boolean checkingFullZero(List<Integer> listOfIntegers) {
        if (listOfIntegers.size() == 3) {
            return listOfIntegers.get(0) == 0 && listOfIntegers.get(1) == 0 && listOfIntegers.get(2) == 0;
        }
        return false;
    }
}
