#-*-coding:utf-8-*-

import tensorflow as tf

v =tf.Variable(2.0, tf.float32, name="v")

for variables in tf.all_variables():
    print(variables.name)

ema = tf.train.ExponentialMovingAverage(0.99)

maintain_ave_op = ema.apply(tf.all_variables())

for variables in tf.all_variables():
    print(variables.name)

saver = tf.train.Saver()

with tf.Session() as sess:
    init_op = tf.initialize_all_variables()
    sess.run(init_op)

    sess.run(tf.assign(v, 10))

    sess.run(maintain_ave_op)
    saver.save(sess, "../data/test/model/persistant-3-model.ckpt")
    print(sess.run([v, ema.average(v)]))
