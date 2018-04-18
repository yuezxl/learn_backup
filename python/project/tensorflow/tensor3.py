#-*-coding:utf-8-*-
import tensorflow as tf

#声明w1、w2两个变量。这里还通过send参数设定了随机种子，
w1 = tf.Variable(tf.random_normal([2,3], stddev = 1, seed = 1))
w2 = tf.Variable(tf.random_normal([3,1], stddev = 1, seed = 1))

x = tf.placeholder(tf.float32, shape=(1,2), name="imput")

z = tf.placeholder(tf.float32, shape=[None, 3], name = "z-input")

a = tf.matmul(x, w1)
y = tf.matmul(a, w2)

z=tf.constant([0.4,0.8,1.0,2.0])


with tf.Session() as sess:
    # sess.run(w1.initializer)
    # sess.run(w2.initializer)
    # print(sess.run(w1))
    print(sess.run(tf.arg_max(z, 0)))