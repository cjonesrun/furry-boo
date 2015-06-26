#!/usr/bin/env bash

# Default priority
PUSHOVER_PRIORITY=0

# I don't care about my logins
if [[ $2 -eq -2 ]]; then
 exit 0
# No notification if you are logged in to your server
elif [[ $3 -eq 1 ]]; then
 PUSHOVER_PRIORITY=-1
# Silent notification for players you don't care about
elif [[ $2 -eq 0 ]]; then
 PUSHOVER_SOUND=none
# No push notification, send directly to app
elif [[ $2 -eq -1 ]]; then
 #PUSHOVER_PRIORITY=-1
 PUSHOVER_SOUND=none
fi

# http://textbelt.com (free sms service)
#curl -X POST http://textbelt.com/canada \
   #-d number=5551234567 \
   #-d "message=I sent this message for free with textbelt.com"

# push over service
#curl -s -F "sound=$PUSHOVER_SOUND" \
  #-F "priority=$PUSHOVER_PRIORITY" \
  #-F "token=$PUSHOVER_APPTOKEN" \
  #-F "user=$PUSHOVER_USERTOKEN" \
  #-F "message=$1" \
  #-F "timestamp=`date +%s`" \
 #	https://api.pushover.net/1/messages.json

# pushbullet service
#curl https://api.pushbullet.com/api/pushes \
   #-u $PUSH_BULLET_APIKEY \
   #-d device_iden=$PUSHBULLET_DEVICE\
   #-d type=note \
   #-d title=Minecraft \
   #-d body="`date +"%a %l:%M%P"` - $1"  \
   #-X POST

# push.co service
#curl -s -F "api_secret=$PUSHCO_SECRET" \
  #-F "api_key=$PUSHCO_KEY" \
  #-F "message=$1" \
  #https://api.push.co/1.0/push

exit 0
