FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
PACKAGECONFIG += " srt " 

PACKAGECONFIG[srt]            = "-Dsrt=enabled,-Dsrt=disabled,libsrt"

