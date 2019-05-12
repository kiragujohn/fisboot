    #!/bin/sh
    # This line makes the shell script exit immediately if there is an error
    set -e
    ################################################################################
    ## File Details
    ################################################################################
    ## NAME:    Repository Clone Automation Script
    ## FILE:    trade43boot/utility/clonerepo/clonerepo.sh

    ################################################################################
    ## Author Details
    ################################################################################
    ## AUTHOR:  Innocent Kagina
    ## CREATED: 03/12/2018

    ################################################################################
    ## Description
    ################################################################################
    ## Automate the process of moving all branches from one repository to another.

    ################################################################################
    ## Main Variables
    ################################################################################
    USERNAME_SOURCE_REPO='innocentkagina'
    USERNAME_DESTINATION_REPO='ik'
    LOCATION_SOURCE_REPO=https://javaspeak.repositoryhosting.com/git/javaspeak/trade43web.git
    LOCATION_DESTINATION_REPO=https://gitbucket.43kare.de/git/Test/testtrade43web.git 

    ################################################################################
    ## Other Variables
    ################################################################################
    USERNAME_SOURCE_URL="https://${USERNAME_SOURCE_REPO}@"
    USERNAME_DEST_URL="https://${USERNAME_DESTINATION_REPO}@"
    LOCATION_SOURCE_REPO=`echo $LOCATION_SOURCE_REPO | sed  "s|[https://]*|$USERNAME_SOURCE_URL|"`
    LOCATION_DESTINATION_REPO=`echo $LOCATION_DESTINATION_REPO | sed  "s|[https://]*|$USERNAME_DEST_URL|"`
    BASE_LOCAL_REPO_FOLDER=~/workspaces/43kare/copyrepo
    CMD="git"

    ################################################################################
    ## Check if Directory Exists & Create It If Not
    ################################################################################
        if [ ! -d $BASE_LOCAL_REPO_FOLDER ]
        then
           mkdir -p $BASE_LOCAL_REPO_FOLDER
           cd $BASE_LOCAL_REPO_FOLDER
        else
           TIMESTAMP=`date +%s`
           mkdir -p $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
           cd $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
       fi

    #This Command Helps to Run Script Easier By Asking For Password Only Once
    #git config --global credential.helper store
    
    ################################################################################
    ## Clone Repository
    ################################################################################
    echo "Fetching From ${LOCATION_SOURCE_REPO}"
    
    $CMD clone  $LOCATION_SOURCE_REPO
    LIST_LOCAL_REPO_FOLDER=`ls`
    cd $LIST_LOCAL_REPO_FOLDER

    ################################################################################
    ## List And Checkout All Branches
    ################################################################################
    echo "Listing Remote Branches"
       RELEASE="releases"
       FEATURE="features"
    $CMD config --global credential.helper store
       $CMD fetch origin
       for BRANCH in `$CMD branch -r | sed -e 's/\(origin\/\|origin\/HEAD\)//' | grep -P  "($RELEASE|$FEATURE)"`
           do
           if [  -n  "$BRANCH" ]
           then
           $CMD checkout -b $BRANCH origin/$BRANCH
           $CMD pull origin $BRANCH
           else
           echo "No Remote Branch Found"
           fi 
           done

    $CMD checkout master
    
    ################################################################################
    ## List All Tags
    ################################################################################
  
    echo "Fetching all Tags"
    $CMD fetch --tags
    $CMD  pull origin master 
    $CMD config --global --unset credential.helper

    ################################################################################
    ## Remove Old Repository URL
    ################################################################################
    echo "Deleting Remote OldURL $LOCATION_SOURCE_REPO"
    $CMD remote rm origin

    ################################################################################
    ## Add New Repository URL
    ################################################################################
    echo "Adding Remote NewURL"
    $CMD remote add origin $LOCATION_DESTINATION_REPO
    $CMD remote -v

    ################################################################################
    ## Push All Branches to New Repository
    ################################################################################
    echo "Pushing Master Branch"
    $CMD push -u origin --all

    ################################################################################
    ## Push All Tags to New Repository
    ################################################################################
    echo "Pushing All Tags"
    $CMD push --tags




