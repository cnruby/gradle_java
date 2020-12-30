#!/usr/bin/env sh
# This file is used for another project.

# Usage
# ./change_app_id <NEU_APP_IP>

PROJECT_ID=111
sed -i "s/basic_${PROJECT_ID}/basic_${1}/g" build.gradle
N1=`echo $1 | cut -c1-1`
N2=`echo $1 | cut -c2-2`
N3=`echo $1 | cut -c3-3`
P1=`echo $PROJECT_ID | cut -c1-1`
P2=`echo $PROJECT_ID | cut -c2-2`
P3=`echo $PROJECT_ID | cut -c3-3`
sed -i 's/'$P1.$P2.$P3'/'$N1.$N2.$N3'/g' build.gradle

# sed -i "s/${PROJECT_ID}/${1}/g" .github/workflows/github_release.yml
sed -i "s/${PROJECT_ID}/${1}/g" .circleci/config.yml
sed -i "s/${PROJECT_ID}/${1}/g" ./README.md
# sed -i "s/${PROJECT_ID}/${1}/g" ./gradle.properties
