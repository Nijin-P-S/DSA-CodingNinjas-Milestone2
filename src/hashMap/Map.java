package hashMap;

import java.util.ArrayList;

public class Map <K,V>{

    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public Map(){
        buckets = new ArrayList<>();
        numBuckets = 20;

        for(int i=0; i<numBuckets; i++)
            buckets.add(null);
    }

    public int size(){
        return count;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    buckets.set(bucketIndex, head.next);
                    return head.value;
                }
                else{
                    prev.next = head.next;
                    return head.value;
                }
            }
            prev = head;
            head = head.next;
        }
        return null;

    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    private int getBucketIndex(K key){
        int hc = key.hashCode();
        int index = hc % numBuckets;
        return index;
    }
    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> node = new MapNode<>(key, value);
        node.next = head;
        buckets.set(bucketIndex, node);
        count++:
    }
}
