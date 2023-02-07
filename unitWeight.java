public class unitWeight {

    static double value;

    public unitWeight() {
        value = 0;
    }

    public unitWeight(double v) {
        value = v;
    }

    // setter & getter
    public double getValue() {
        return value;
    }

    public void setValue(double v) {
        value = v;
    }

    /*
     * function to ConvertTo
     * Input : String, (resp. kg, lbs or oz)
     * Output : value * convertRation
     * Default = input
     */
    public static double convertKgTo(String unit) {
        switch (unit) {
            case "lbs":
                return value * 2.20462262185;
            case "oz":
                return value * 35.27396195;
            default:
                return value;
        }
    }

    public static double convertLbsTo(String unit) {
        switch (unit) {
            case "kg":
                return value * 0.45359237;
            case "oz":
                return value * 16;
            default:
                return value;
        }
    }

    public static double convertOzTo(String unit) {
        switch (unit) {
            case "kg":
                return value * 0.02834952;
            case "lbs":
                return value * 0.0625;
            default:
                return value;
        }
    }

    /*
     * Input : String String
     * Output: double of converted value
     * Default = input
     */
    public double convert(String from, String to) {
        switch (from) {
            case "kg":
                return convertKgTo(to);
            case "lbs":
                return convertLbsTo(to);
            case "oz":
                return convertOzTo(to);
            default:
                return value;
        }
    }
}
