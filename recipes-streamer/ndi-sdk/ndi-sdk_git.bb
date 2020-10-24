SUMMARY = "NDI SDK Binaries"
DESCRIPTION = "NewTek's innovative Network Device Interface technology"
LICENSE = "CLOSED"
SECTION = "libs"

SRC_URI = "git://git.bybram.com/community/ndi-linux-sdk.git"
SRC_URI[sha256sum] = "fdb422e61ac07b6531e7eaa0f69d9f6e9a80544d109b2d3d7a5a04fec7340781"

SRCREV = "4113a4494f909d0b81ba8fe73f74a7fbcd1dc9dc"

S = "${WORKDIR}/git"

DEPENDS = "avahi"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${includedir}

	cp -a --no-preserve=ownership ${S}/bin/arm-newtek-linux-gnueabihf/* ${D}${bindir}
	cp -a --no-preserve=ownership ${S}/lib/arm-newtek-linux-gnueabihf/* ${D}${libdir}
	cp -a --no-preserve=ownership ${S}/include/* ${D}${includedir}
}

FILES_SOLIBSDEV = ""

FILES_${PN} += "\
	${bindir}/* \
	${libdir}/* \
"

FILES_${PN}-dev += "\
	${includedir}/* \
"

# Pre-build binaries are already stripped
INSANE_SKIP_${PN} += "already-stripped"

# We have no GNU_HASH in the elf binaries
INSANE_SKIP_${PN} += "ldflags"

INSANE_SKIP_${PN} += "libdir staticdev dev-so"
