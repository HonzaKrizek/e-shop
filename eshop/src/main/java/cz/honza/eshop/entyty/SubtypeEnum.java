package cz.honza.eshop.entyty;

public enum SubtypeEnum {
    SWORD(TypeEnum.WEAPON),
    AXE(TypeEnum.WEAPON),
    BLUNT(TypeEnum.WEAPON),
    PLATE(TypeEnum.ARMOR),
    LEATHER(TypeEnum.ARMOR),
    CHAIN(TypeEnum.ARMOR),
    RING(TypeEnum.TRINKET),
    NECKLACE(TypeEnum.TRINKET),
    EARRING(TypeEnum.TRINKET);

    final TypeEnum typeOfSubtype;

    SubtypeEnum(TypeEnum type) {
        this.typeOfSubtype = type;
    }

    public TypeEnum getType() {
        return this.typeOfSubtype;
    }

}
