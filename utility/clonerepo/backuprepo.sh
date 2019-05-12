#!/bin/sh
    # This line makes the shell script exit immediately if there is an error
    set -e
    ################################################################################
    ## File Details
    ################################################################################
    ## NAME:    Repository Clone Automation Script
    ## FILE:    trade43boot/utility/clonerepo/backuprepo.sh

    ################################################################################
    ## Author Details
    ################################################################################
    ## AUTHOR:  Innocent Kagina
    ## CREATED: 12/12/2018

    ################################################################################
    ## Description
    ################################################################################
    ## Automate the process of backing up all repositories.

    ################################################################################
    ## Repository Variables
    ################################################################################
    TRADE43BOOT_REPO=https://gitbucket.43kare.de/git/Trade/trade43boot.git
    TRADE43WEB_REPO=https://gitbucket.43kare.de/git/Trade/trade43web.git
    TRADE43KATALON_REPO=https://gitbucket.43kare.de/git/Trade/trade43katalon.git
    TRADE43KATALONDB_REPO=https://gitbucket.43kare.de/git/Trade/trade43katalondb.git
    KATALON_REPO=https://gitbucket.43kare.de/git/Member/member43katalon.git
    DOCS_SITE_REPO=https://gitbucket.43kare.de/git/DevDocs/devdocs.git
    SPRINGBOOT_REPO=https://gitbucket.43kare.de/git/Member/member43boot.git
    DYNAMIC_SITE_REPO=https://gitbucket.43kare.de/git/Member/member43web.git

    BASE_LOCAL_REPO_FOLDER=~/backup_repo
    CMD="git"

    ################################################################################
    ## Check if Backup Directory Exists & Create It If Not
    ################################################################################
        if [ ! -d $BASE_LOCAL_REPO_FOLDER ]
        then
           TIMESTAMP=`date +"%Y_%m_%d_%H_%M_%S"`
           mkdir -p $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
           cd $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
        else
           TIMESTAMP=`date +"%Y_%m_%d_%H_%M_%S"`
           mkdir -p $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
           cd $BASE_LOCAL_REPO_FOLDER/$TIMESTAMP
        fi

    #This Command Helps to Run Script Easier By Asking For Password Only Once
    git config --global credential.helper store
    git config --global http.sslVerify false
    
    ################################################################################
    ## Clone All Repositories
    ################################################################################
    echo "Fetching From ${TRADE43BOOT_REPO}"    
    $CMD clone  $TRADE43BOOT_REPO
    echo "====================================="

    echo "Fetching From ${TRADE43WEB_REPO}" 
    $CMD clone  $TRADE43WEB_REPO
    echo "====================================="

    echo "Fetching From ${TRADE43KATALON_REPO}" 
    $CMD clone  $TRADE43KATALON_REPO
    echo "====================================="

    echo "Fetching From ${TRADE43KATALONDB_REPO}" 
    $CMD clone  $TRADE43KATALONDB_REPO
    echo "====================================="

    echo "Fetching From ${KATALON_REPO}" 
    $CMD clone  $KATALON_REPO
    echo "====================================="

    echo "Fetching From ${DOCS_SITE_REPO}" 
    $CMD clone  $DOCS_SITE_REPO
    echo "====================================="

    echo "Fetching From ${SPRINGBOOT_REPO}" 
    $CMD clone  $SPRINGBOOT_REPO
    echo "====================================="

    echo "Fetching From ${DYNAMIC_SITE_REPO}" 
    $CMD clone  $DYNAMIC_SITE_REPO
    echo "====================================="

    echo "All Repos Have Been Successfully Cloned & Backuped"
    $CMD config --global --unset credential.helper
