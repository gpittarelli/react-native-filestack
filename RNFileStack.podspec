Pod::Spec.new do |s|
  s.name         = "RNFileStack"
  s.version      = "1.0.0"
  s.summary      = "RNFileStack"
  s.description  = <<-DESC
                  Filestack picker for react-native
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  s.author       = { "author" => "g@gjp.cc" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/gpittarelli/react-native-filestack.git", :tag => "master" }
  s.requires_arc = true

  s.dependency "React"
  #s.dependency "others"

  s.source_files  = "ios/*.{h,m}"
  s.public_header_files = 'ios/RNFileStack.h"
end
