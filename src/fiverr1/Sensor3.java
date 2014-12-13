package fiverr1;

public class Sensor3 {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void f(int a, int b, int k) {
        if (k % gcd(a, b) == 0) {
            System.out.println("YES");
            if (a != k) {
                calculateSequence(a, b, k);
            }
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

        boolean isIdle = true;

        String result = "";
        char previous = 0;

        while (b != 0) {
            while (!(a >= 0 && a < abs(b))) {
                isIdle = false;
                if (a < 0) {
                    a = a + abs(b);

                    if (b >= 0) {
                        countX++;
                        if (previous == 'y') {
                            countY--;
                            countX--;
                        }
                        previous = 'x';
                    } else {
                        countY++;
                        if (previous == 'x') {
                            countY--;
                            countX--;
                        }
                        previous = 'y';
                    }

                    if ((k - a) % b == 0) {
                        isValid = true;
                        break;
                    }

                } else if (a >= abs(b)) {
                    a = a - abs(b);
                    if (b >= 0) {
                        countY++;
                        if (previous == 'x') {
                            countY--;
                            countX--;
                        }
                        previous = 'y';
                    } else {
                        countX++;
                        if (previous == 'y') {
                            countY--;
                            countX--;
                        }
                        previous = 'x';
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
            if (previous == 'y') {
                countY--;
                if (countY > 0) {
                    result += "Y " + countY + "\n";
                }
                countY = 0;
            } else {
                countX++;
            }
            previous = 'x';

            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

            b = a - b;
            countZ++;
            if (previous == 'x') {

                if (countX > 0) {
                    result += "X " + countX + "\n";
                }
                countX = 0;
            }

            result += "Z " + countZ + "\n";
            previous = 'z';
            countZ = 0;

            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

            a = a - b;
            countY++;
            previous = 'y';
            if ((k - a) % b == 0) {
                isValid = true;
                break;
            }

        }
        if (isValid) {

            if (previous == 'y') {
                if (countY != 0 && !((k >= a && b < 0) || (k < a && b >= 0))) {
                    result += "Y " + countY + "\n";
                    previous = 0;
                }
                countX = 0;
            } else if (previous == 'x') {
                if (countX != 0 && !((k >= a && b >= 0) || (k < a && b < 0))) {
                    result += "X " + countX + "\n";
                    previous = 0;
                }
                countY = 0;
            }
            int limit = abs((k - a) / b);
            for (int i = 0; i < limit; i++) {

                if (k < a) {

                    if (b < 0) {
                        a = a + b;
                        countX++;
                        previous = 'x';

                    } else if (b >= 0) {

                        a = a - b;
                        countY++;
                        previous = 'y';
                    }
                } else if (k >= a) {

                    if (b < 0) {
                        a = a - b;
                        countY++;
                        previous = 'y';

                    } else if (b >= 0) {

                        a = a + b;
                        countX++;
                        previous = 'x';
                    }
                }

            }
            if (previous == 'x') {
                result += "X " + countX + "\n";
            } else if (previous == 'y') {
                result += "Y " + countY + "\n";
            }
        } else if (!isValid) {

            b = a - b;
            countZ++;

            if ((factor - 1) > 0) {
                if (previous == 'y') {
                    result += "Y " + countY + "\n";
                    countX = 0;
                }

                for (int i = 0; i < factor - 1; i++) {
                    a = a + b;
                    countX++;
                }
                result += "X " + countX + "\n";
            } else if ((factor - 1) < 0) {

                if (previous == 'x') {
                    result += "X " + countX + "\n";
                    countY = 0;
                }

                for (int i = 0; i < -factor + 1; i++) {
                    a = a - b;
                    countY++;
                }
                result += "Y " + countY + "\n";
            }

        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

    public static int abs(int a) {
        return (a <= 0) ? 0 - a : a;
    }
}
