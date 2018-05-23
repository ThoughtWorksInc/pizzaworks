#!/usr/bin/env bash

(./build-scripts/test.sh && ./build-scripts/integration-tests.sh && ./build-scripts/functional-tests.sh )
