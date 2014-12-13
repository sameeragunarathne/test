package fiverr1;

public class Sensor {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void f(int a, int b, int k) {
        if (k % gcd(a, b) == 0) {
            System.out.println("YES");
            if(a!=k)
            calculateSequence(a, b, k);
        } else {
            System.out.println("NO");
        }
    }

    public void calculateSequence(int a, int b, int k) {

        int gcd = gcd(a, b);
        int factor = k / gcd;

        int countX = 0;
        int countY = 0;
        int countZ = 0;

        boolean isValid = false;

        boolean isXop = false;
        boolean isYop = false;
        boolean isZop = false;
        boolean isIdle=true;

        String result = "";

        while (b != 0) {
            while (!(a >= 0 && a < abs(b))) {
                isIdle=false;
                if (a < 0) {
                    a = a + abs(b);

                    if (b >= 0) {
                        countX++;
                        isXop = true;
                    } else {
                        countY++;
                        isYop = true;
                    }

                    // checking the out put can get from a multiple of b from here
                    if ((k - a) % b == 0) {
                        isValid = true;
                        break;
                    }

                } else if (a >= abs(b)) {
                    a = a - abs(b);
                    if (b >= 0) {
                        countY++;
                        isYop = true;
                    } else {
                        countX++;
                        isXop = true;
                    }

                    if ((k - a) % b == 0) {
                        isValid = true;
                        break;
                    }
                }
            }

            if (isValid) {
                break;
            }

            a = a + b;
            
             if(isIdle){
             result += "X: " + ++countX + "\n";
             isXop=true;
             countX=0;
            }

            if (countX != 0) {
                result += "X: " + ++countX + "\n";
                countX = 0;
            }

            if (!isXop) {
                countY--;
                if(countY!=0)
                result += "Y: " + countY + "\n";
                countY = 0;
            }
            isXop = false;
            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

            b = a - b;
            countZ++;

            result += "Z: " + countZ + "\n";
            countZ = 0;

            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

            a = a - b;
            countY++;
            isYop = true;
            isXop = false;

            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

        }
        if (!isValid) {

            b = a - b;
            countZ++;

            if ((factor - 1) > 0) {
                if (!isXop) {
                    result += "Y: " + countY + "\n";
                    isYop = false;
                    countX = 0;
                }

                for (int i = 0; i < factor - 1; i++) {
                    a = a + b;
                    countX++;

                }
                result += "X: " + countX + "\n";
            } else if ((factor - 1) < 0) {

                if (!isYop) {
                    result += "X: " + countX + "\n";
                    isXop = false;
                    countY = 0;
                }

                for (int i = 0; i < -factor + 1; i++) {
                    a = a - b;
                    countY++;

                }
                result += "Y: " + countY + "\n";
            }

        } else {

            if (isYop) {
                if (countY != 0 && !((k > a && b < 0) || (k < a && b > 0))) {
                    result += "Y: " + countY + "\n";
                }
                isYop = false;
                countX = 0;
            } else if (isXop) {
                if (countX != 0 && !((k > a && b > 0) || (k < a && b < 0))) {
                    result += "X*: " + countX + "\n";
                }
                isXop = false;
                countY = 0;
            }
            int limit = abs((k - a) / b);
            for (int i = 0; i < limit; i++) {

                if (k < a) {

                    if (b < 0) {
                        a = a + b;
                        countX++;
                        isXop = true;

                    } else if (b > 0) {

                        a = a - b;
                        countY++;
                        isYop = true;
                    }
                } else if (k > a) {

                    if (b < 0) {
                        a = a - b;
                        countY++;
                        isYop = true;

                    } else if (b > 0) {

                        a = a + b;
                        countX++;
                        isXop = true;
                    }
                }

            }
            if (isXop) {
                result += "X: " + countX + "\n";
            } else if (isYop) {
                result += "Y: " + countY + "\n";
            }
        }

        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

    public static int abs(int a) {
        return (a <= 0) ? 0 - a : a;
    }
}
