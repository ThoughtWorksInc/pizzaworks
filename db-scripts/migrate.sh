#!/usr/bin/env bash

(cd migrations && pg-migrator postgres://superpizza:$PIZZA_WORKS_PW@localhost/pizzaworks)
