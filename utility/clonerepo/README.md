    # CloneRepo

    CloneRepo is a Shell Script that clones all branches in repository and moves it to another.

    ## Installation

    Use bash Shell  to run CloneRepo.
    Ensure the Script is executable by user running it.

    ## Usage

    1. Open Terminal

    2. Navigate To Folder Containing Shell Script

      -cd ~/Trade43boot/Utility/Clonerepo

    3. Check If Shell Script Is Executable

      -ls -l

    4. If Script Is Not Executable,Make It Executable

      -sudo Chmod U+X clonerepo.sh

    5. Check And Edit Variables With Editor

      -sudo Vim clonerepo.sh

    6. Search For Following Lines And Add Respective Values For Each Variable ;

       USERNAME_SOURCE_REPO       #ADD USERNAME OF THE SOURCE REPOSITORY e.g innocentkagina
       USERNAME_DESTINATION_REPO  #ADD USERNAME OF THE DESTINATION REPOSITORY e.g innocentkagina
       LOCATION_SOURCE_REPO       #ADD URL OF THE SOURCE REPOSITORY e.g https://      javaspeak.repositoryhosting.com/git/javaspeak/testreleasetwo.git
       LOCATION_DESTINATION_REPO  #ADD URL OF THE DESTINATION REPOSITORY e.g https://      javaspeak.repositoryhosting.com/git/javaspeak/testreleasethree.git

    7. Run Script

       ./clonerepo.sh

    8. Wait For Cloning Process To Finish

    Location of new repository should now be installed in following place ;

       ~/workspaces/43kare/copyrepo/









