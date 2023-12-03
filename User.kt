import listeners.INotifyPropertyChangedListener
import listeners.INotifyPropertyChangingListener

class User(
    name: String = "Pavel",
    surname: String = "Bobnev"
) : INotifyPropertyChangedListener, INotifyPropertyChangingListener {

    val changed_list: ArrayList<(name: String) -> Unit> = ArrayList()
    val changing_list: ArrayList<(new_value: Any?, old_value: Any?) -> Boolean> = ArrayList()
    private var name: String = name
    private var surname: String = surname


    fun getName(): String {
        return name
    }

    fun getSurname(): String {
        return surname
    }

    fun setName(name: String) {
        changing_list.forEach {
            val is_cancelable = it.invoke(name, this.name)
            if (is_cancelable) return
        }
        this.name = name
        changed_list.forEach { it.invoke("Name") }
    }

    fun setSurname(surname: String) {
        changing_list.forEach {
            val is_cancelable = it.invoke(surname, this.surname)
            if (is_cancelable) return
        }
        this.surname = surname
        changed_list.forEach { it.invoke("Surname") }
    }

    override fun addNotifyPropertyChangedListener(f: (property_name: String) -> Unit) {
        changed_list.add(f)
    }

    override fun removeNotifyPropertyChangedListener(f: (property_name: String) -> Unit) {
        changed_list.remove(f)
    }

    override fun addNotifyPropertyChangedListener(f: (new_value: Any?, old_value: Any?) -> Boolean) {
        changing_list.add(f)
    }

    override fun removeNotifyPropertyChangedListener(f: (new_value: Any?, old_value: Any?) -> Boolean) {
        changing_list.remove(f)
    }
}