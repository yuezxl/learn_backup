package learn_map;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class RBTree<T extends Comparable<T>>{
	
	private RBTNode<T> mRoot; // 根节点 
	
	public void createRBTree(T t) {
		this.mRoot = new RBTNode<T>(t, false, null, null, null);
	}
	
	List<String> resultList = new ArrayList<>();
	
	// 左旋
	public void leftRotate(RBTNode<T> node) {
		if(node == null) {
			throw new java.lang.IllegalStateException("node is null");
		}
		RBTNode<T> right = node.right;
		if(right == null) {
			throw new java.lang.IllegalStateException("right node is null");
		}
		
		if(node.parent == null) {
			this.mRoot = right;
		} else {
			right.parent = node.parent;
		}
		node.parent = right;
		node.right = right.left;
		right.left = node;
	}
	
	// 右旋
	public void rightRotate(RBTNode<T> node) {
		if(node == null) {
			throw new java.lang.IllegalStateException("node is null");
		}
		
		RBTNode<T> left = node.left;
		if(left == null) {
			throw new java.lang.IllegalStateException("left is null");
		}
		
		if(node.parent == null) {
			this.mRoot = left;
		} else {
			left.parent = node.parent;
		}
		node.parent = left;
		node.left = node.right;
		left.right = node;
		
	}
	
	// 重新着色
	public void fixRBTree(RBTNode<T> node) {
		while(node.isRed) {
			RBTNode<T> parent = node.parent;
			if(parent == null) {
				this.mRoot = node;
				node.isRed = false;
			}
			if(!parent.isRed) 
				break;
			
			RBTNode<T> grandParent = parent.parent;
			if(parent == grandParent.left) {
				RBTNode<T> uncle = grandParent.right;
				if(uncle != null && uncle.isRed) {
					grandParent.isRed = true;
					uncle.isRed = false;
					parent.isRed = true;
					node = grandParent;
				} else if(node == parent.right) {
					// 对parent左旋，然后交换node与parent
					leftRotate(parent);
					// 当前节点为parent
					node = parent;
				} else {
					parent.isRed = false;
					grandParent.isRed = true;
					rightRotate(grandParent);
				}
			} else {
				RBTNode<T> uncle = grandParent.left;
				if(uncle != null && uncle.isRed) {
					grandParent.isRed = true;
					uncle.isRed = false;
					parent.isRed = false;
					node = grandParent;
				} else if(node == parent.left) {
					// 右旋
					rightRotate(parent);
					node = parent;
				} else {
					parent.isRed = false;
					grandParent.isRed = true;
					leftRotate(grandParent);
				}
			}
		}
		this.mRoot.isRed = false;
	}
	
	// 插入
	public void insert(T key) {
		RBTNode<T> node = new RBTNode<T>(key, true, null, null, null);
		RBTNode<T> walk = this.mRoot;
		RBTNode<T> prev = null;
		// 如果树根是空，则新建一颗树
		if(walk == null) {
			this.mRoot = node;
			mRoot.isRed = false;
			return;
		}
		
		// 查找node待插入的位置
		while(walk != null) {
			prev = walk;
			if(key.compareTo(walk.key) < 0) {
				walk = walk.left;
			} else if(key.compareTo(walk.key) > 0){
				walk = walk.right;
			} else {
				walk.count ++;
				return;
			}
		}
		
		// walk为NIL节点，则node的parent应该为walk的父节点
		RBTNode<T> walkParent = prev;
		if(key.compareTo(walkParent.key) < 0) {
			walkParent.left = node;
		} else {
			walkParent.right = node;
		}
		node.parent = walkParent;
		
		this.fixRBTree(node);
	}
	
	
	public RBTNode<T> getUncle(RBTNode<T> node) {
		RBTNode<T> parent = node.parent;
		if(parent != null && parent.parent != null) {
			if(parent == parent.parent.left) {
				return parent.parent.right;
			} else {
				return parent.parent.left;
			}
		}
		return null;
	}
	
	public RBTNode<T> getmRoot() {
		return mRoot;
	}

	public void setmRoot(RBTNode<T> mRoot) {
		this.mRoot = mRoot;
	}
	
	public List<String> getRBTree(int index) {
		resultList = new ArrayList<>();
		if(index == 0) {
			return this.getLeftRBTreeValue(this.mRoot);
		} else if(index == 1) {
			return this.getRBTreeValue(this.mRoot);
		} else {
			return this.getRightRBTreeValue(this.mRoot);
		}
	}
	
	// 删除红黑树的节点
	public void delete(T key) {
		// 先找到待删除的结点
		RBTNode<T> node = findNode(key);
		if(node == null) {
			return;
		}
		// 根据不同情况进行调整
		while(true) {
			// 情况1：
			if(node.left == null && node.right == null && node.isRed) {
				if(node == node.parent.left) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
				return;
			}
			
			// 情况2：
			if(node.left == null && node.right == null && !node.isRed) {
				
			}
		}
	}
	
	// 删除修复
	public void reomveFixUp(RBTNode<T> node, RBTNode<T> parent) {
		if(node != parent && node != parent.right) {
			return;
		}
		RBTNode<T> brother = node == parent.left ? parent.right : parent.left;
		if(brother == null) {
			return;
		}
		
		while((node == null || !node.isRed) && (node != this.mRoot)) {
			if(node == parent.left) {
				if(brother.isRed) {
					brother.isRed = false;
					parent.isRed = true;
					leftRotate(parent);
					
				}
			}
		}
	}
	
	// 查找结点
	public RBTNode<T> findNode(T key) {
		RBTNode<T> node = this.mRoot;
		while(true && node!= null) {
			if(key.compareTo(node.key) > 0) {
				node = node.right;
			} else if(key.compareTo(node.key) < 0) {
				node = node.left;
			} else {
				return node;
			}
			break;
		}
		return null;
	}
	
	// 中序遍历
	public List<String> getLeftRBTreeValue(RBTNode<T> node) {
		if(node != null) {
			getLeftRBTreeValue(node.left);
			resultList.add(node.toString());
			getLeftRBTreeValue(node.right);
		}
		return resultList;
	}
	
	// 前序遍历
	public List<String> getRBTreeValue(RBTNode<T> node) {
		if(node != null) {
			resultList.add(node.toString());
			getRBTreeValue(node.left);
			getRBTreeValue(node.right);
		}
		return resultList;
	}
	
	// 后序遍历
	public List<String> getRightRBTreeValue(RBTNode<T> node) {
		if(node != null) {
			getRightRBTreeValue(node.right);
			resultList.add(node.toString());
			getRightRBTreeValue(node.left);
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		RBTree<NodeKey> rbtree = new RBTree<>();
		rbtree.insert(new Data(1));
		rbtree.insert(new Data(2));
		rbtree.insert(new Data(3));
		rbtree.insert(new Data(4));
		rbtree.insert(new Data(0));
		
		System.out.println(rbtree.getRBTree(0));
		
		System.out.println(rbtree.getRBTree(1));
		
		System.out.println(rbtree.getRBTree(2));
	}
}

class RBTNode<T extends Comparable<T>> {
	boolean isRed;
	T key;
	RBTNode<T> parent;
	RBTNode<T> left;
	RBTNode<T> right;
	int count;
	
	RBTNode(T key, boolean isRed, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
		this.key = key;
		this.isRed = isRed;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.count = 1;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("key=").append(key.toString()).append(":").append("red=").append(isRed).append(":").append("count=").append(count);
		return stringBuilder.toString();
	}
}
 