#-*-coding:utf-8-*-

import tensorflow as tf

reader = tf.train.NewCheckpointReader("../data/test/model/persistant-1-model.ckpt");

all_vars = reader.get_variable_to_shape_map()

for var in all_vars:
    print(var, all_vars[var])

print("Value for variable v1 is", reader.get_tensor("Variable"))
