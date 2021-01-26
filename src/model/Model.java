package model;

public class Model
{
    private static ModularCounter red = new ModularCounter(256);
    private static ModularCounter green = new ModularCounter(256);
    private static ModularCounter blue = new ModularCounter(256);

    public void chanceColorViaAbsoluteValue(ColorCode cc, int value)
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

    public void chanceColorViaRelativeValue(ColorCode cc, String input)
    {
        switch (input)
        {
            case "+":
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

            case "-":
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
        String hex = "#";

        String redValue = Integer.toHexString(red.getValue());
        String greenValue = Integer.toHexString(green.getValue());
        String blueValue = Integer.toHexString(blue.getValue());

        if (redValue.length() == 1)
            redValue = "0" + redValue;
        if (greenValue.length() == 1)
            greenValue = "0" + greenValue;
        if (blueValue.length() == 1)
            blueValue = "0" + blueValue;

        hex += redValue;
        hex += greenValue;
        hex += blueValue;

        return hex;
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

    public static void printConsoleMenu() {}

    public static void printCurrentValues() {}
}