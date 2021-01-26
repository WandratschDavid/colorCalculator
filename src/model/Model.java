package model;

import java.util.Scanner;

public class Model
{
    private static ModularCounter red = new ModularCounter(256);
    private static ModularCounter green = new ModularCounter(256);
    private static ModularCounter blue = new ModularCounter(256);


    public static void chanceColorViaAbsoluteValue(ColorCode cc, int value)
    {
        if (value >= 0 && value <= 255)
        {
            switch (cc)
            {
                case RED:
                    red.reset();
                    red.inc(value);
                    break;

                case GREEN:
                    green.reset();
                    green.inc(value);
                    break;

                case BLUE:
                    blue.reset();
                    blue.inc(value);
                    break;
            }
        }
    }

    public static void chanceColorViaRelativeValue(ColorCode cc, String input)
    {
        switch (input)
        {
            case "+10":
                if (cc == ColorCode.RED && red.getValue() + 10 < red.getModulus())
                {
                    red.inc(10);
                }
                else if (cc == ColorCode.GREEN && green.getValue() + 10 < green.getModulus())
                {
                    green.inc(10);
                }
                else
                    {
                        if (blue.getValue() + 10 < blue.getModulus())
                            blue.inc(10);
                    }
                break;

            case "-10":
                if (cc == ColorCode.RED && red.getValue() - 10 >= 0)
                {
                    red.dec(10);
                }
                else if (cc == ColorCode.GREEN && green.getValue() - 10 >= 0)
                {
                    green.dec(10);
                }
                else
                    {
                        if (blue.getValue() - 10 >= 0)
                            blue.dec(10);
                    }
                break;
        }
    }

    public static int getRed() {return red.getValue();}

    public static int getGreen() {return green.getValue();}

    public static int getBlue() {return blue.getValue();}

    public static String getHex()
    {
        String hexCode = "#";

        String redValue = Integer.toHexString(red.getValue());
        String greenValue = Integer.toHexString(green.getValue());
        String blueValue = Integer.toHexString(blue.getValue());

        if (redValue.length() == 1)
            redValue = "0" + redValue;
        if (greenValue.length() == 1)
            greenValue = "0" + greenValue;
        if (blueValue.length() == 1)
            blueValue = "0" + blueValue;

        hexCode += redValue;
        hexCode += greenValue;
        hexCode += blueValue;

        return hexCode;
    }

    @Override
    public String toString()
    {
        return "Model{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    public static void printConsoleMenu()
    {
        System.out.println("Please choose one of the following options:");
        System.out.println("a - changeColorViaAbsoluteValue" + "\nr - changeColorViaRelativeValue" + "\n? - view all accessors" + "\nq - quit" + "\n");
    }

    public static void printCurrentColorValues()
    {
        System.out.println("Red = " + getRed() + "\nGreen = " + getGreen() + "\nBlue = " + getBlue() + "\nHexvalue = #" + getHex() + "\n");
    }


    public static void main(String[] args)
    {
        String userChoice;
        Scanner sc = new Scanner(System.in);

        do
        {
            printConsoleMenu();
            userChoice = sc.next();

            switch(userChoice)
            {
                case "a":
                    System.out.println("Please enter red, green or blue!");
                    String userColorInputAbsolute = sc.next();

                    System.out.println("Please enter a number from 0 - 255!");
                    int userValueInputAbsolute = sc.nextInt();

                    switch(userColorInputAbsolute)
                    {
                        case "red":
                            chanceColorViaAbsoluteValue(ColorCode.RED, userValueInputAbsolute);
                            break;

                        case "green":
                            chanceColorViaAbsoluteValue(ColorCode.GREEN, userValueInputAbsolute);
                            break;

                        case "blue":
                            chanceColorViaAbsoluteValue(ColorCode.BLUE, userValueInputAbsolute);
                            break;

                        default:
                            System.out.println("Please only enter one of the above mentioned colors!");
                            break;
                    }
                    break;

                case "r":
                    System.out.println("Please enter red, green or blue!");
                    String userColorInputRelative = sc.next();

                    System.out.println("Please enter +10 or -10!");
                    String userValueInputRelative = sc.next();

                    switch(userColorInputRelative)
                    {
                        case "red":
                            chanceColorViaRelativeValue(ColorCode.RED, userValueInputRelative);
                            break;

                        case "green":
                            chanceColorViaRelativeValue(ColorCode.GREEN, userValueInputRelative);
                            break;

                        case "blue":
                            chanceColorViaRelativeValue(ColorCode.BLUE, userValueInputRelative);
                            break;

                        default:
                            System.out.println("Please only enter one of the above mentioned colors!");
                            break;
                    }
                    break;

                case "?":
                    printCurrentColorValues();
                    break;

                case "q":
                    System.exit(-1);
                    break;

                default:
                    System.out.println("Wrong input!");
                    System.out.println("Please only enter one from the above mentioned letters!");
                    break;
            }
        }
        while(true);
    }
}