fun main() {

    val user = User()
    val list = ObservableList<String>()
    user.addNotifyPropertyChangedListener({ it -> println(it) })
    user.addNotifyPropertyChangedListener { new_value: Any?, old_value: Any? ->
        println("Old value:${old_value.toString()}")
        println("New value: ${new_value.toString()}")
        println("Property doesn't changed")
        true
    }

    // Демонстрация работы с коллекцией
    list.addNotifyPropertyChangedListener { status -> println(status.toString()) }
    list.add("element")
    list.set(0, "new_element")
    list.remove("new_element")

    // Демонстрация работы с объектами
    user.setName("new_name")
    user.setSurname("new_surname")
    println(user.getName() + " " + user.getSurname())
}