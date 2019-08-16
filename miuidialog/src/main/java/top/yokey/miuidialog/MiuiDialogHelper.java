package top.yokey.miuidialog;

@SuppressWarnings("ALL")
public class MiuiDialogHelper {

    private int listArrow = 0;
    private int accentColor = 0;
    private int negativeColor = 0, positiveColor = 0;
    private static volatile MiuiDialogHelper instance = null;

    public static MiuiDialogHelper get() {

        if (instance == null) {
            synchronized (MiuiDialogHelper.class) {
                if (instance == null) {
                    instance = new MiuiDialogHelper();
                }
            }
        }
        return instance;

    }

    public int getListArrow() {

        return listArrow;

    }

    public void setListArrow(int listArrow) {

        this.listArrow = listArrow;

    }

    public int getAccentColor() {

        return accentColor;

    }

    public void setAccentColor(int accentColor) {

        this.accentColor = accentColor;

    }

    public int getNegativeColor() {

        return negativeColor;

    }

    public void setNegativeColor(int negativeColor) {

        this.negativeColor = negativeColor;

    }

    public int getPositiveColor() {

        return positiveColor;

    }

    public void setPositiveColor(int positiveColor) {

        this.positiveColor = positiveColor;

    }

}
