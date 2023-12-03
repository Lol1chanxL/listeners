package listeners

interface INotifyPropertyChangingListener {
    fun addNotifyPropertyChangedListener(f: (new_value: Any?, old_value: Any?) -> Boolean)
    fun removeNotifyPropertyChangedListener(f: (new_value: Any?, old_value: Any?)  -> Boolean)
}