package go.kevin.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianrui Wang
 * @date 2022-03-17 20:10
 **/
public class TestLfu {

	/**
	 * 实现一个LFU
	 *
	 * 频次记录
	 * 单点获取
	 * 固定大小 最低淘汰
	 * 小顶堆 hashMap
	 */

	public static void main(String[] args) {

		LfuCache cache = new LfuCache(3);

		for (int i = 1; i <= 3; i++){
			LfuCache.Node node = new LfuCache.Node();
			node.key = "key" + i;
			node.value = i;
			cache.put(node.key, node);
		}

		cache.get("key1");
		cache.get("key1");

		LfuCache.Node node4 = new LfuCache.Node();
		node4.key = "key4";
		node4.value = 0;
		cache.put(node4.key, node4);

		System.out.println(cache.map);
	}

	static class LfuCache{

		private int size;
		private int cap;
		private Map<String, Node> map;
		private Heap heap;

		public LfuCache(int cap){
			this.size = 0;
			this.cap = cap;
			map	= new HashMap<>(cap);
			heap = new Heap();
			heap.nodeArray = new Node[cap+1];
			heap.heapSize = 0;
		}

		public Node get(String key){
			if (map.get(key) == null){
				return null;
			}

			Node node = map.get(key);
			heap.plusOne(node);
			return node;
		}

		public void put(String key, Node node){
			if (map.get(key) != null){
				Node oldNode = map.get(key);
				map.put(key, node);
				heap.nodeArray[oldNode.index] = node;
				heap.plusOne(node);
				return;
			}

			if (size + 1 > cap){
				Node oldNode = heap.removeRoot();
				map.remove(oldNode.key);
			}
			map.put(key, node);
			size++;
			heap.add(node);
		}



		static class Node {
			public String key;
			public int value;
			public int index;

			@Override
			public String toString() {
				return "Node{" +
						"key='" + key + '\'' +
						", value=" + value +
						", index=" + index +
						'}';
			}
		}

		static class Heap {
			int heapSize;
			public Node[] nodeArray;

			public void add(Node node){

				nodeArray[heapSize] = node;
				node.index = heapSize++;

				while (node.index > 0){
					int parentIndex = (node.index - 1 ) / 2;
					Node parent = nodeArray[parentIndex];
					if (parent.value < node.value){
						break;
					}

					swap(nodeArray, node.index, parentIndex);
					parent.index = node.index;
					node.index = parentIndex;
				}
			}

			public void plusOne(Node node){
				node.value += 1;
				while (node.index < heapSize){
					int nodeIndex = node.index;
					int leftSon = node.index * 2 + 1;
					int rightSon = node.index * 2 + 2;

					if (leftSon >= heapSize){
						break;
					}
					Node minNode = nodeArray[leftSon].value < nodeArray[rightSon].value ? nodeArray[leftSon] : nodeArray[rightSon];


					swap(nodeArray, minNode.index, node.index);
					node.index = minNode.index;
					minNode.index = nodeIndex;
				}
			}

			public Node removeRoot(){
				// 替换根节点
				Node root = nodeArray[0];
				Node node = nodeArray[heapSize - 1];
				node.index = 0;
				swap(nodeArray, heapSize - 1, 0);
				heapSize--;

				while (node.index < heapSize){
					int nodeIndex = node.index;
					int leftSon = node.index * 2 + 1;
					int rightSon = node.index * 2 + 2;
					Node minNode = nodeArray[leftSon].value < nodeArray[rightSon].value ? nodeArray[leftSon] : nodeArray[rightSon];
					swap(nodeArray, minNode.index, node.index);
					node.index = minNode.index;
					minNode.index = nodeIndex;
				}

				return root;
			}
		}

		public static void swap(LfuCache.Node[] nums, int index1, int index2){
			LfuCache.Node temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
		}





	}







}
