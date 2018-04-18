#-*-coding:utf-8-*-

import tensorflow as tf

v1 = tf.Variable(tf.constant(1.0, shape=[1], name="v1"))
v2 = tf.Variable(tf.constant(2.0, shape=[1], name="v2"))

result = v1 + v2

init_op = tf.initialize_all_variables()

server = tf.train.Saver()

with tf.Session()  as sess:
    sess.run(init_op)
    server.save(sess, "../data/test/model/persistant-1-model.ckpt")
