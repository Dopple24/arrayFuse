public static ArrayList<Component> fuseArrays(ArrayList<Component> oldArray, ArrayList<Component> newArray) {

    if (newArray.isEmpty()) return new ArrayList<>(); //if newArray is empty, nothing has to be added

    if (oldArray.isEmpty()) return newArray; //if oldArray is empty, only newArray is returned

    if (oldArray.size() == 1) { //handles a case with only one component in oldArray
        if (oldArray.get(0).equals(newArray.get(0))) { //if both arrays have the same first component, it is most probably safe to return NewArray
            return newArray; //POSSIBLE BREAKING POINT
        }
        System.out.println("notEnoughDataError"); //should fetch again with higher n
    }

    for (int i = newArray.size() - 1; i >= 0; i--) { //selects one of the components from newArray, starts at the last one
        boolean isContinues = true;

        for (int j = 0; j <= i; j++) { //compares selected Component from newArray with the last component from oldArray
            if (!oldArray.get(oldArray.size() - 1 - j).equals(newArray.get(i - j))) { //if any of the comparisons is false, moves to the next component in newArray
                isContinues = false;
                break;
            }
        }

        if (isContinues && i < 1) { //handles a case where only one component is overlapping
            System.out.println("notEnoughData"); //one overlapping component is not enough
        }

        if (isContinues) { // if continues components are found, new returnList is created with components added accordingly
            ArrayList<Component> returnList = new ArrayList<>();
            for (int k = i + 1; k < newArray.size(); k++) {
                returnList.add(newArray.get(k));
            }
            return returnList;
        }
    }

    System.out.println("notEnoughDataError"); //should fetch again with higher n
    return new ArrayList<>(); // should be deleted, is in place only for java to compile this
}
