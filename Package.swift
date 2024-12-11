// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "BringForegroundPlugin",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "BringForegroundPlugin",
            targets: ["ForegroundPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "ForegroundPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/ForegroundPluginPlugin"),
        .testTarget(
            name: "ForegroundPluginPluginTests",
            dependencies: ["ForegroundPluginPlugin"],
            path: "ios/Tests/ForegroundPluginPluginTests")
    ]
)