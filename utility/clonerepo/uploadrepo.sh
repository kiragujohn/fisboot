#!/bin/sh

# This line makes the shell script exit immediately if there is an error


set -e

################################################################################

## File Details

################################################################################

## NAME: Repository Clone Automation Script

## FILE: trade43boot/utility/clonerepo/uploadrepo.sh

################################################################################

## Author Details

################################################################################

## AUTHOR: Innocent Kagina

## CREATED: 12/12/2018

################################################################################

## Description

################################################################################

## Automate the process of Uploading/Pushing Local Repo to Remote Repo.

################################################################################

## Main Variables

################################################################################
USERNAME_DESTINATION_REPO=NOT_SET
LOCATION_DESTINATION_REPO=NOT_SET

################################################################################

## Other Variables

################################################################################
LOCATION_DESTINATION_REPO=`echo $LOCATION_DESTINATION_REPO | sed "s|[https://]*|$USERNAME_DEST_URL|"`
CMD="git"

################################################################################

## List And Checkout All Branches

################################################################################


echo "Listing Remote Branches"


RELEASE="releases"


FEATURE="features"


#$CMD config --global credential.helper store


for BRANCH in `$CMD branch -a | sed -e 's/\(origin\/\|origin\/HEAD\)//' | grep -P  "($RELEASE|$FEATURE)"`

do


if [ -n "$BRANCH" ]

then


$CMD checkout -b $BRANCH origin/$BRANCH


$CMD push -u origin $BRANCH

else


echo "No Remote Branch Found"

fi

done


$CMD checkout master

################################################################################

## Push All Branches to New Repository

################################################################################


echo "Pushing Master Branch"


$CMD push -u origin --all

echo "============================================================================="
echo "All Branches Have Been Successfully Pushed"
