package com.shw.array;

/**
 * @author WillShuai自定义数组类
 * @date 2018/12/23--19:28
 */
public class Array<E> {
    //初始的数据
    private E[] data;
    //初始的数组的大小
    private int size;

    //默认有参数的构造方法
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    //默认午餐的构造方法
    public Array() {
        //默认容量为10
        this(10);
    }
    //获取到数组中个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }
    //获取到当前元素是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //向最后的元素中插入一个新的元素
    public void addLast(E e){
        add(size, e);
    }
    //想数组中的第0个元素插入一个数
    public void addFrist(E e){
        add(0,e);
    }
    //在指定的位置插入一个新的元素
    public void add(int index,E e){
        //判断用户输入的索引是否合法
        if(index <0 || index >size){
            throw new IllegalArgumentException("插入失败！请检查您输入的索引是否合法！");
        }
        //判断数组的长度
        if(size == data.length){
            resize(2*data.length);
        }
        for(int i = size-1;i >=index;i--){
            //将所有的元素向后移动一个位置
            data[i + 1] = data[i];
        }
        //给当前位置赋值（注意，当前要插入的下标的值不是不在了，而是将它进行覆盖）
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("size："+size+"，length:"+data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    //根据index的索引取出数组中的元素
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("数组的索引不对！");
        }
        return data[index];
    }
    //修改index位置的元素
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("数组的索引不对！");
        }
        data[index] = e;
    }
    //查找数组中是否包含某个元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //根据对象返回其所在位置
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //根据下标进行删除元素,返回被删除的元素
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("数组的索引不对！");
        }
        E ret = data[index];
        for (int i = index+1;i<size;i++) {
            data[i - 1] = data[i];
        }
        size--;
        //在进行移除的时候，size这个位置还持有上一个对象的引用，（GC垃圾回收不能够检测到，所以我们需要进行手动处理，如果不进行处理也是没有问题的）
        data[size] = null;
        if(size<data.length/2){
            //如果当前的元素个数小于容量的二分之一，那么进行缩小容量
            resize(data.length / 2);
        }
        return ret;
    }
    //删除第一个元素
    public E removeFrist(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }
    //
    public void removeElement(int e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }
    //得到最后一个元素
    public E getLast(){
        return get(size - 1);
    }
    //得到第一个元素
    public E getFirst(){
        return get(0);
    }
    //动态扩容
    private void resize(int newCapacity) {
        //创建一个新的数组，这个数组是之前数组的2倍大小
        E[] newData = (E[]) new Object[newCapacity];
        //将之前旧的数据添加到新的数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //对data进行重新赋值
        data = newData;
    }
}