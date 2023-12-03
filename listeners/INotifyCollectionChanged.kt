package listeners

interface INotifyCollectionChanged {
    fun addNotifyPropertyChangedListener(f: (status: Status) -> Unit)
    fun removeNotifyPropertyChangedListener(f: (status: Status) -> Unit)

}
enum class Status {Added, Removed, ItemChanged}