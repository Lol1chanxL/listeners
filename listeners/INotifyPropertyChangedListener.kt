package listeners

interface INotifyPropertyChangedListener {
    fun addNotifyPropertyChangedListener(f: (property_name: String) -> Unit)
    fun removeNotifyPropertyChangedListener(f: (property_name: String) -> Unit)
}