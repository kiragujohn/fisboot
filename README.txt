================================================================================
README.txt
================================================================================

This readme contains useful instructions and info that we can forget.


================================================================================
Specifying env when starting java
================================================================================

-Dspring.profiles.active=dev


================================================================================
JWT Spring Boot side authentication
================================================================================

Spring scans classpath for a class that implements UserDetailsService.  that 
class has the following method:

    UserDetails loadUserByUsername(..)
       
Our class is:

    AppUserDetailsService


================================================================================
Running boot in dev mode
================================================================================

Run StartTradeBoot


================================================================================
Running web in dev mode
================================================================================

In console:

     npm start
     
Edit host file:

    ##
    # Host Database
    #
    # localhost is used to configure the loopback interface
    # when the system is booting.  Do not change this entry.
    ##
    #127.0.0.1      localhost Johns-MacBook-Pro.local
    #127.0.0.1      www.localhost.com Johns-MacBook-Pro.local
    127.0.0.1       womenkare.43kare-member.de mazzeye.43kare-member.de womenkare.trade43.de www.localhost.com localhost Johns-MacBook-Pro.local
    255.255.255.255 broadcasthost
    ::1             localhost
    # localhost       womenkare.43kare-member.de

open in browser:

    http://womenkare.trade43.de:4200/


================================================================================
Running boot in dev mode
================================================================================




================================================================================
Urls in prod and test
================================================================================

Prod

    https://womenkare.43kare-trade.de
    https://inana01.43kare.de/home
    
test

    https://staging.womenkare.43kare-trade.de


    


