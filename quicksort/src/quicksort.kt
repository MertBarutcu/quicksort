fun quickSort(comp: Comparator<E>){
    //AbbruchBedingung
    if (size() < 2) {
        for (e in this) println("Sortierte Liste? " +e)
        return
    }
    //Refernezgröße festlegen:
    val pivot = getFirst()

    val less = SimpleLinkedList<E>()
    val equal = SimpleLinkedList<E>()
    val greater = SimpleLinkedList<E>()
    for (e in this ) {
        val compared = comp.compare(e, pivot)
        when {
            compared < 0 -> less.addFirst(e)
            compared == 0 -> equal.addFirst(e)
            compared > 0 -> greater.addFirst(e)
        }
    }
    less.quickSort(comp)
    equal.quickSort(comp)
    greater.quickSort(comp)
    removeAll()
    //Hier gibt es verbesserungs Potential listen direkt hinter einander hängen und nicht alle nach einander
    //zsm führen.
    for (e in less) addLast(e)
    for (e in equal) addLast(e)
    for (e in greater) addLast(e)
    isSorted = true
}