#-*-coding:utf-8-*-

import tensorflow as tf
from numpy.random import RandomState


a = tf.constant([1.0,2.0], name="a")
b = tf.constant([2.0,3.0], name="b")

rdm = RandomState(1)
X=rdm.rand(2,2)
Y=tf.constant([[1.0,2.0], [3.0,4.0]])


result = a + b

result2 = X + Y

sess = tf.InteractiveSession()
print(result.eval())
print(a.graph is tf.get_default_graph())
print(b.graph is tf.get_default_graph())
print(result.graph is tf.get_default_graph())
print(Y.get_shape())
sess.close()