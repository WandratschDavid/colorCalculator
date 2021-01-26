package model;

public class Model
{
    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;

    public Model()
    {
        this.red = new ModularCounter(0, 256);
        this.green = new ModularCounter(0, 256);
        this.blue = new ModularCounter(0, 256);
    }

    public void chanceColorViaAbsoluteValue(ColorCode cc, String value)
    {

    }

    public void chanceColorViaAbsoluteValue(ColorCode cc, int value)
    {

    }

    public void chanceColorViaRelativeValue(ColorCode cc, String value)
    {

    }

    public void chanceColorViaRelativeValue(ColorCode cc, int value)
    {

    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    public String getHex()
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

    }
}