#-*-coding:utf-8-*-

import tensorflow as tf

v = tf.Variable(0, dtype=tf.float32, name="v")
v1 = tf.Variable(0, dtype=tf.float32, name="v1")

saver = tf.train.Saver({"v/ExponentialMovingAverage":v, "v":v1})

with tf.Session() as sess:
    saver.restore(sess, "../data/test/model/persistant-3-model.ckpt")
    print(sess.run([v, v1]))