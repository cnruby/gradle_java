#!/usr/bin/env sh
# This file is used for another project.

# Usage
# ./change_app_id <NEU_APP_IP>

sed -i "s/basic_115/basic_${1}/g" build.gradle
N1=`echo $1 | cut -c1-1`
N2=`echo $1 | cut -c2-2`
N3=`echo $1 | cut -c3-3`
sed -i 's/'1.0.4'/'$N1.$N2.$N3'/g' build.gradle
