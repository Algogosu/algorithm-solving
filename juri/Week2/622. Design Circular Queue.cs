public class MyCircularQueue
{
    private List<int> queue;
    private int k;

    public MyCircularQueue(int k)
    {
        queue = new List<int>();
        this.k = k;
    }

    public bool EnQueue(int value)
    {
        if (queue.Count() == k)
        {
            return false;
        }
        else
        {
            queue.Add(value);
            return true;
        }
    }

    public bool DeQueue()
    {
        if (queue.Count() > 0)
        {
            queue.RemoveAt(0);
            return true;
        }
        else
        {
            return false;
        }
    }

    public int Front()
    {
        if (queue.Count() > 0)
        {
            return queue.First();
        }
        else
        {
            return -1;
        }
    }

    public int Rear()
    {
        if (queue.Count() > 0)
        {
            return queue.Last();
        }
        else
        {
            return -1;
        }
    }

    public bool IsEmpty()
    {
        if (queue.Count() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public bool IsFull()
    {
        if (queue.Count() == k)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * bool param_1 = obj.EnQueue(value);
 * bool param_2 = obj.DeQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * bool param_5 = obj.IsEmpty();
 * bool param_6 = obj.IsFull();
 */