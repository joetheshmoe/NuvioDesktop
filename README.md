<div align="center">

  <img src="https://github.com/tapframe/NuvioTV/blob/main/assets/brand/app_logo_wordmark.png" alt="Nuvio" width="300" />
  <br />
  <br />

  [![License][license-shield]][license-url]

  <p>
    *DOES NOT WORK YET- HTTP requests and media playback not yet implemented*
    A modern media hub for Linux (and beyond) built with Kotlin Multiplatform and Compose Multiplatform.
    <br />
    Stremio addon ecosystem • Desktop-first
  </p>

</div>

## About

Nuvio has been ported to Linux native as a Compose Desktop application. It delivers a full-featured media playback experience with collection tools, watch progress flows, downloads, and Stremio addon ecosystem integration — all running natively on Linux.

The app is built from a single shared codebase in [composeApp](./composeApp), with platform-specific entry points for desktop (JVM), Android, and iOS.

## Installation

### Linux

#### Prebuilt packages

Download the latest release from [GitHub Releases](https://github.com/NuvioMedia/NuvioMobile/releases/latest).

Available formats:
- **AppImage** — Portable, works on any Linux distro (no installation required)
- **DEB** — Debian/Ubuntu packages

#### AppImage

```bash
chmod +x Nuvio-x86_64.AppImage
./Nuvio-x86_64.AppImage
```

#### DEB package

```bash
sudo dpkg -i nuvio_*.deb
```

**Dependencies for video playback:**

- **libvlc** (recommended): `sudo apt install vlc` (Debian/Ubuntu) or equivalent for your distribution.

The player falls back gracefully with a placeholder if no playback library is detected.

## Development

### Prerequisites

- **JDK 17 or later** — Required for both compilation and running.
- A Linux desktop environment (X11 or Wayland).
- For video playback after VLCJ integration: [libvlc](https://www.videolan.org/vlc/) (`sudo apt install vlc` or equivalent).

### Quick Start

```bash
git clone https://github.com/NuvioMedia/NuvioMobile.git
cd NuvioMobile
./gradlew :composeApp:run --no-configuration-cache
```

The first build downloads Gradle 8.14.3 and all dependencies automatically. The `--no-configuration-cache` flag is recommended for first-time builds or when changing build scripts.

### Useful Commands

```bash
# Run the desktop app
./gradlew :composeApp:run

# Run with configuration cache disabled (use if build changes don't take effect)
./gradlew :composeApp:run --no-configuration-cache

# Just compile the desktop target (faster than a full run)
./gradlew :composeApp:compileKotlinDesktop

# Build a distribution package (DEB, MSI, DMG)
./gradlew :composeApp:packageDistributionForCurrentOS

# Build a native DEB package
./gradlew :composeApp:packageDeb

# Build an uber JAR (fat JAR with all dependencies)
./gradlew :composeApp:packageUberJarForCurrentOS
# Output: composeApp/build/compose/jars/Nuvio-linux-x64-<version>.jar

# Build a portable AppImage (see instructions below)
./gradlew :composeApp:packageUberJarForCurrentOS
appimagetool AppDir Nuvio-x86_64.AppImage
```

### Building an AppImage

To build a portable AppImage (no Java runtime required on the target system):

1. **Install appimagetool** — Download from [AppImage releases](https://github.com/AppImage/AppImageKit/releases):
   ```bash
   wget https://github.com/AppImage/AppImageKit/releases/download/continuous/appimagetool-x86_64.AppImage
   chmod +x appimagetool-x86_64.AppImage
   sudo mv appimagetool-x86_64.AppImage /usr/local/bin/appimagetool
   ```

2. **Build the uber JAR:**
   ```bash
   ./gradlew :composeApp:packageUberJarForCurrentOS
   ```

3. **Create the AppDir structure:**
   ```bash
   export VERSION=$(grep 'releaseAppVersionName' composeApp/build.gradle.kts | head -1 | grep -oP '\d+\.\d+\.\d+')
   mkdir -p AppDir/usr/lib
   cp composeApp/build/compose/jars/Nuvio-linux-x64-*.jar AppDir/usr/lib/nuvio.jar
   cp composeApp/src/commonMain/composeResources/drawable/app_logo_wordmark.png AppDir/nuvio.png
   ```

4. **Create the launcher script** (`AppDir/AppRun`):
   ```bash
   cat > AppDir/AppRun << 'EOF'
   #!/bin/bash
   SELF=$(readlink -f "$0")
   HERE=${SELF%/*}
   JAVA=$(which java 2>/dev/null)
   if [ -z "$JAVA" ]; then
       echo "Error: Java 17+ not found. Install a JDK or bundle the JRE."
       exit 1
   fi
   exec "$JAVA" -jar "${HERE}/usr/lib/nuvio.jar" "$@"
   EOF
   chmod +x AppDir/AppRun
   ```

5. **Create the desktop file** (`AppDir/nuvio.desktop`):
   ```bash
   cat > AppDir/nuvio.desktop << 'EOF'
   [Desktop Entry]
   Name=Nuvio
   Comment=A modern media hub for Linux
   Exec=nuvio
   Icon=nuvio
   Type=Application
   Categories=AudioVideo;Player;
   Terminal=false
   EOF
   ```

6. **Package the AppImage:**
   ```bash
   ARCH=x86_64 appimagetool AppDir Nuvio-x86_64.AppImage
   ```

The resulting `Nuvio-x86_64.AppImage` is a single-file portable application.

### Project Structure

- `composeApp/` contains the shared Kotlin Multiplatform and Compose Multiplatform app code.
- `composeApp/src/commonMain/` contains shared UI, features, repositories, and platform-agnostic logic.
- `composeApp/src/desktopMain/` contains Linux desktop-specific integrations (JVM-based).
- `composeApp/src/androidMain/` contains Android-specific integrations.
- `composeApp/src/iosMain/` contains iOS-specific integrations.

## Media Playback

The desktop player currently uses a stub implementation that displays a placeholder. To enable actual video playback, wire up one of:

- **VLCJ** — Java bindings for libvlc (dependency already declared in `build.gradle.kts`)
- **MPV via IPC** — Spawn an `mpv` process and control it through a socket
- **GStreamer** — Via gstreamer-java bindings

The `PlatformPlayerSurface` composable in `desktopMain` is the integration point.

## Known Desktop Limitations

| Feature | Status |
|---|---|
| Video playback | Stub — needs VLCJ/MPV integration |
| Plugins/JS addons | Not yet available on desktop |
| P2P streaming | Not supported on desktop |
| Notifications | No system notification integration |
| External player launch | No desktop external player detection |
| Picture-in-Picture | Not applicable on desktop |
| Background downloads | Works in-process |

## Legal & DMCA

Nuvio functions solely as a client-side interface for browsing metadata and playing media provided by user-installed extensions and/or user-provided sources. It is intended for content the user owns or is otherwise authorized to access.

Nuvio is not affiliated with any third-party extensions, catalogs, sources, or content providers. It does not host, store, or distribute any media content.

For comprehensive legal information, including our full disclaimer, third-party extension policy, and DMCA/Copyright information, please visit our [Legal & Disclaimer Page](https://nuvioapp.space/legal).

## Built With

- Kotlin Multiplatform
- Compose Multiplatform (Desktop)
- Kotlin
- Ktor (networking)
- Coil (image loading)
- VLCJ / libvlc (media playback — optional)

## Star History

<a href="https://www.star-history.com/#NuvioMedia/NuvioMobile&type=date&legend=top-left">
 <picture>
   <source media="(prefers-color-scheme: dark)" srcset="https://api.star-history.com/svg?repos=NuvioMedia/NuvioMobile&type=date&theme=dark&legend=top-left" />
   <source media="(prefers-color-scheme: light)" srcset="https://api.star-history.com/svg?repos=NuvioMedia/NuvioMobile&type=date&legend=top-left" />
   <img alt="Star History Chart" src="https://api.star-history.com/svg?repos=NuvioMedia/NuvioMobile&type=date&legend=top-left" />
 </picture>
</a>

<!-- MARKDOWN LINKS & IMAGES -->
[license-shield]: https://img.shields.io/github/license/NuvioMedia/NuvioMobile.svg?style=for-the-badge
[license-url]: https://github.com/NuvioMedia/NuvioMobile/blob/main/LICENSE
