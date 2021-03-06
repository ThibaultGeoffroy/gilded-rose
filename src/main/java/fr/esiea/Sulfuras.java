package fr.esiea;

public class Sulfuras extends Item {

    public Sulfuras(int sellIn, int quality, boolean conjured) throws QualityException, SellInException {
        super(Constants.SULFURAS_NAME, sellIn, quality, conjured);
        if(this.quality != 80) {
            throw new QualityException("Quality of a Sulfura object must be equal to 80");
        }
        if(this.sellIn != 0) {
            throw new SellInException("Sellin of a Sulfura object must be equal to 0");
        }
    }

    public void update() {}
}
