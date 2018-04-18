#-*-coding:utf-8-*-
import tensorflow as tf
from numpy.random import RandomState

rdm = RandomState(1)
dataset_size = 2;
X = rdm.rand(dataset_size, 2)

Y=[[int(x1+x2 <1)] for(x1,x2) in X]

A=tf.constant([[1.0,2.0, 3.0, 4.0]])
B=tf.constant([[3.0,2.0,2.0,3.0]])
with tf.Session()  as sess:
    print(X.shape)
    print(X)
    print(Y)
    print(sess.run(tf.square(A-B)))
    print(sess.run(tf.reduce_mean(tf.square(A-B))))