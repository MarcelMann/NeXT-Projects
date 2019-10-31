#!/bin/bash
sshpass -p 'lejos' ssh -o KexAlgorithms=+diffie-hellman-group1-sha1 -c aes128-cbc root@10.0.1.1 'rm /home/lejos/programs/*.*'

