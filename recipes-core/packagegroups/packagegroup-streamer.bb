DESCRIPTION = "User space componentd for Streamer"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-streamer \
"

RDEPENDS_packagegroup-streamer = "\
   ffmpeg \
   alsa-utils \
   dropbear \
   gstreamer1.0 \
   gstreamer1.0-plugins-base \
   gstreamer1.0-plugins-good \
   gstreamer1.0-plugins-ugly \
   gstreamer1.0-plugins-bad \
   gstreamer1.0-rtsp-server \
   gstreamer1.0-omx \
   avahi-utils \
   v4l-utils \
   libsrt \
"
