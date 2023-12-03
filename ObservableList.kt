import listeners.INotifyCollectionChanged
import listeners.Status

class ObservableList<T> : ArrayList<T>(), INotifyCollectionChanged {
    private val collectionChangedListeners = ArrayList<(Status) -> Unit>()
    override fun add(element: T): Boolean {
        notifyCollectionChanged(Status.Added)
        return super.add(element)
    }

    override fun remove(element: T): Boolean {
        notifyCollectionChanged(Status.Removed)
        return super.remove(element)

    }

    override fun set(index: Int, element: T): T {
        notifyCollectionChanged(Status.ItemChanged)
        return super.set(index, element)
    }


    private fun notifyCollectionChanged(status: Status) {
        collectionChangedListeners.forEach { it.invoke(status) }
    }

    override fun addNotifyPropertyChangedListener(f: (status: Status) -> Unit) {
        collectionChangedListeners.add(f)
    }

    override fun removeNotifyPropertyChangedListener(f: (status: Status) -> Unit) {
        collectionChangedListeners.remove(f)
    }

}