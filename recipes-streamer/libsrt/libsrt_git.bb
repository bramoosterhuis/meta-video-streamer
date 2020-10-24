SUMMARY = "Secure Reliable Transport"
DESCRIPTION = "Secure Reliable Transport (SRT) is an open source transport technology \
               that optimizes streaming performance across unpredictable networks, \
               such as the Internet."
HOMEPAGE = "www.srtalliance.org"
SECTION = "libs"
LICENSE = "MPLv2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/Haivision/srt.git \
           "
SRCREV = "2641221553802ea29e402e70ff1e2812f592d920"

S = "${WORKDIR}/git"


DEPENDS = "openssl"

inherit cmake pkgconfig

INSANE_SKIP_${PN} += "dev-deps file-rdeps"
