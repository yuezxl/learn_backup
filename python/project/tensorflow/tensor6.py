#-*-coding:utf-8-*-

import tensorflow as tf

X=[[1.0,2.0,3.0,4.0,5.0], [3.0,4.0, 7.0, 8.0, 9.0]]

mean = tf.reduce_mean(X, 0)

B = tf.constant([1.0,10.0,100.0,1000.0], name="B")



with tf.Session() as sess:
    print(sess.run(mean))
    print(sess.run(tf.reduce_max(X, 0)))
    print(sess.run(tf.clip_by_value(X, 4,6)))
    print(sess.run(tf.log(B)))
