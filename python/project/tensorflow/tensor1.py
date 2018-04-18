#-*-coding:utf-8-*-
import tensorflow as tf

a = tf.constant([1.0,2.0], name="a")
b = tf.constant([2.0,3.0], name="b")

result = a + b
with tf.Session() as sess:
    print(sess.run(result))
    print(result.eval())
    c = 1
    if(c == 1) :
        print(1)